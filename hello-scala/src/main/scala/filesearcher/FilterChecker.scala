package filesearcher

/**
 * Created by liviu.ignat on 3/10/2015.
 */
class FilterChecker(filter: String) {
  def matches(content: String) = content.contains(filter)

  def findMatchedFiels(fileList: List[IOObject]) = {
    for(fileObject <- fileList
      if(fileObject.isInstanceOf[FileObject])
      if (matches(fileObject.name)))
    yield fileObject
  }
}
