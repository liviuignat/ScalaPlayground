package filesearcher

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
}

/*
* Companion Object for FilterChecker
* It enables us not to use new
* */
object FilterChecker {
  def apply(filter: String) = new FilterChecker(filter)
}
