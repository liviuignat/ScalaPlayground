package filesearcher

import java.io.File
import scala.io.Source
import scala.util.control.NonFatal

/**
 * Created by liviu.ignat on 3/10/2015.
 */
class FilterChecker(filter: String) {
  def matches(content: String) = content.contains(filter)

  /*
  * No brackets is named "infix notation"
  * */
  def findMatchedFiles(fileList: List[IOObject]) =
    for(fileObject <- fileList
      if(fileObject.isInstanceOf[FileObject])
      if (matches(fileObject.name)))
    yield fileObject

  def matchesFilterContent(file: File): Boolean = {
    try {
      val fileSource = Source.fromFile(file)

      try {
        fileSource.getLines().exists(line => matches(line))
      } catch {
        case NonFatal(_) => false
      } finally {
        fileSource.close()
      }

    } catch {
      case NonFatal(_) => false
    }
  }
}

/*
* Companion Object for FilterChecker
* It enables us not to use new
* */
object FilterChecker {
  def apply(filter: String) = new FilterChecker(filter)
}
