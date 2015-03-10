package filesearcher

import java.io.File
import org.scalatest.FunSpec



/**
 * Created by liviu.ignat on 3/10/2015.
 */
class FilterCheckerSpec extends FunSpec {
  describe("When passed a list to the filter and a file matches") {
    it("Should return a list with that file") {
      val listOfFiles = List(new FileObject(new File("random")), new FileObject(new File("match")))
      val matchedFiles = FilterChecker("match") findMatchedFiles(listOfFiles)
      assert(matchedFiles == List(new FileObject(new File("match"))))
    }
  }

  describe("When passed a list with a directory in it") {
    it("Should never return the directory from it") {
      val listOfFiles = List(new FileObject(new File("random")), new FileObject(new File("match")))
      val matchedFiles = FilterChecker("match") findMatchedFiles(listOfFiles)
      assert(matchedFiles == List(new FileObject(new File("match"))))
    }
  }
}
