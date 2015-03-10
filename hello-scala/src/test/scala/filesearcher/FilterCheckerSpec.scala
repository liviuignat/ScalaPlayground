package filesearcher
import org.scalatest.FlatSpec


/**
 * Created by liviu.ignat on 3/10/2015.
 */
class FilterCheckerSpec extends FlatSpec {
  "When passed a list to the filter and a file matches" should
  "return a list with that file" in {
    val matchingFile = new FileObject("match")
    val listOfFiles = List(new FileObject("random"), matchingFile)
    val matchedFiles = new FilterChecker("match").findMatchedFiels(listOfFiles)

    assert(matchedFiles == List(matchingFile))
  }
}
