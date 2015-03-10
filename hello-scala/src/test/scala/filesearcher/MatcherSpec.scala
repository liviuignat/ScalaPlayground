package filesearcher

import java.io.File

import org.scalatest.FlatSpec

/**
 * Created by liviu.ignat on 3/10/2015.
 */
class MatcherSpec extends FlatSpec {
  "Matcher that is passed a file matching the filter" should
  "return a list with that file name" in {
    val matcher = new Matcher("fake", "fakePath")
    val results = matcher.execute()
    assert(results == List("fakePath"))
  }

  "Matcher with sub folder checking matching a root location with two subtree files matching" should
  "return a list with those files names" in {
    val searchSubDirectories = true
    val matcher = new Matcher("txt", new File(".\\testfiles\\").getCanonicalPath(), searchSubDirectories)
    val results = matcher.execute()
    assert(results == List("readme.txt", "notes.txt"))
  }
}
