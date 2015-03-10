package filesearcher

import java.io.File

import org.scalatest.FunSpec

/**
 * Created by liviu.ignat on 3/10/2015.
 */
class MatcherSpec extends FunSpec {
  describe("When matcher that is passed a file matching the filter") {
    val matcher = new Matcher("fake", "fakePath")
    val results = matcher.execute()

    it("Should return a list with that file name") {
      assert(results == List("fakePath"))
    }
  }

  describe("When matcher with sub folder checking matching a root location with two subtree files matching") {
    val searchSubDirectories = Some(false)
    val matcher = new Matcher("txt", new File(".\\testfiles\\").getCanonicalPath(), searchSubDirectories)
    val results = matcher.execute()

    it("Should return a list with those files names") {
      assert(results == List("notes.txt", "readme.txt"))
    }
  }

  describe("When matcher with sub folder checking matching a root location but no subtree search is allowed") {
    val matcher = new Matcher("txt", new File(".\\testfiles\\").getCanonicalPath())
    val results = matcher.execute()

    it("Should return a list with those files names") {
      assert(results == List("notes.txt", "readme.txt"))
    }
  }

  describe("When matcher is given a path that matches file and content filter") {
    val matcher = new Matcher("json", new File(".\\testfiles\\").getCanonicalPath(), Some(true), Some("Liviu"))
    val results = matcher.execute()

    it("Should return a list with those files names") {
      assert(results == List("hello-scala.json"))
    }
  }

  describe("When matcher is given a path that matches file, but no content filter is passed") {
    val matcher = new Matcher("json", new File(".\\testfiles\\").getCanonicalPath(), Some(true))
    val results = matcher.execute()

    it("Should return a list with those files names") {
      assert(results == List("hello-scala.json"))
    }
  }

  describe("When matcher is given a path that matches .json files and content filter") {
    val matcher = new Matcher("txt", new File(".\\testfiles\\").getCanonicalPath(), Some(true), Some("Liviu"))
    val results = matcher.execute()

    it("Should return an empty list") {
      assert(results == List())
    }
  }

  describe("When matcher is given a path that matches .txt files, but no content filter is passed") {
    val matcher = new Matcher("txt", new File(".\\testfiles\\").getCanonicalPath(), Some(true))
    val results = matcher.execute()

    it("Should return an empty list") {
      assert(results == List("notes.txt", "readme.txt"))
    }
  }
}
