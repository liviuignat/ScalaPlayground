package filesearcher
import java.io.File

/**
 * Created by liviu.ignat on 3/10/2015.
 */
class Matcher(val filter: String, val rootLocation: String) {
  val rootIOObject = FileToIOObjectConverter.convertToIOObject(new File(rootLocation))

  def execute() = {
    val matchedFiles = rootIOObject match {
      case file: FileObject if FilterChecker(filter).matches(file.name) => List(file)
      case directory: DirectoryObject => ???
      case _ => List()
    }

    matchedFiles.map(iOObject => iOObject.name)
  }
}
