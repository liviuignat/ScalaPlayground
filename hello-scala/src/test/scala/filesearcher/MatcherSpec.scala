package filesearcher

import java.io.File

import org.scalatest.FunSpec

/**
 * Created by liviu.ignat on 3/10/2015.
 */
class MatcherSpec extends FunSpec {
  describe("When matcher that is passed a file matching the filter") {
    it("Should return a list with that file name") {
      val matcher = new Matcher("fake", "fakePath")
      val results = matcher.execute()
      assert(results == List("fakePath"))
    }
  }

  describe("When matcher with sub folder checking matching a root location with two subtree files matching") {
    it("Should return a list with those files names") {
      val searchSubDirectories = true
      val matcher = new Matcher("txt", new File(".\\testfiles\\").getCanonicalPath(), searchSubDirectories)
      val results = matcher.execute()
      assert(results == List("readme.txt", "notes.txt"))
    }
  }
}
