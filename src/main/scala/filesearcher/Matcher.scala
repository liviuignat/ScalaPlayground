package filesearcher
import java.io.File

import scala.annotation.tailrec

/**
 * Created by liviu.ignat on 3/10/2015.
 */
class Matcher(val filter: String,
              val rootLocation: String,
              val checkSubFolders: Option[Boolean] = None,
              val contentFilter: Option[String] = None) {

  val rootIOObject = FileToIOObjectConverter.convertToIOObject(new File(rootLocation))

  def execute() = {
    @tailrec
    def recursiveMatch(files: List[IOObject], currentList: List[FileObject]) : List[FileObject] = {
      files match {
        case List() => currentList
        case iOObject :: rest =>
          iOObject match {
            case file: FileObject if FilterChecker(filter) matches file.name =>
              recursiveMatch(rest, file :: currentList)
            case directory: DirectoryObject =>
              recursiveMatch(rest ::: directory.children(), currentList)
            case _ => recursiveMatch(rest, currentList)
          }
      }
    }

    val matchedFiles = rootIOObject match {
      case file: FileObject if FilterChecker(filter).matches(file.name) => List(file)
      case directory: DirectoryObject =>
        checkSubFolders match {
          case Some(true) => recursiveMatch(directory.children(), List())
          case _ =>FilterChecker(filter).findMatchedFiles(directory.children())
        }
      case _ => List()
    }

    val matchedContentFileFilter = contentFilter match {
      case Some(dataFilter) =>
        matchedFiles.filter(ioObject => FilterChecker(dataFilter).matchesFilterContent(ioObject.file))
      case None => matchedFiles
    }

    matchedContentFileFilter.map(iOObject => iOObject.name).sortBy(name => name)
  }
}
