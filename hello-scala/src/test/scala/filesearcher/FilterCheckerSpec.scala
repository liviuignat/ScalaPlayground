package filesearcher

import java.io.File
import org.scalatest.{FunSpec}


/**
 * Created by liviu.ignat on 3/10/2015.
 */
class FilterCheckerSpec extends FunSpec {
  describe("When passed a list to the filter and a file matches") {
    val listOfFiles = List(new FileObject(new File("random")), new FileObject(new File("match")))
    val matchedFiles = FilterChecker("match") findMatchedFiles(listOfFiles)

    it("Should return a list with that file") {
      assert(matchedFiles == List(new FileObject(new File("match"))))
    }
  }

  describe("When passed a list with a directory in it") {
    val listOfFiles = List(new FileObject(new File("random")), new FileObject(new File("match")))
    val matchedFiles = FilterChecker("match") findMatchedFiles(listOfFiles)

    it("Should never return the directory from it") {
      assert(matchedFiles == List(new FileObject(new File("match"))))
    }
  }

  describe("When passed a file that contains a string that matches the file content") {
    val isContentMatched = FilterChecker("Liviu")
        .matchesFilterContent(new File("./testfiles/hello-scala.json"))

    it("Should return that the match succeeded") {
      assert(isContentMatched == true)
    }
  }

  describe("When passed a file that contains a string that does not matches the file content") {
    val isContentMatched = FilterChecker("Something else")
      .matchesFilterContent(new File("./testfiles/hello-scala.json"))

    it("Should return that the match succeeded") {
      assert(isContentMatched == false)
    }
  }
}
