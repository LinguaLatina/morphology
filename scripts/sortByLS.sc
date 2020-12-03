import scala.io.Source
import java.io.PrintWriter

// Sort a CEX of verb stems by their sequence in Lewis-Short.
// Here's an example file:
val verbFile = "datasets/shared/stems-tables/verbs-simplex/verbs.cex"

// This is for Lewis-Short.  You can add others if you have
// your own URN strings with numeric terminal value.
val prefixList = Vector("ls.n")

def stripPrefix(s: String, prefixes: Vector[String]): String = {
  if (prefixes.isEmpty) {
    s
  } else {
    stripPrefix(s.replaceFirst(prefixes.head, ""), prefixes.tail)
  }
}

/**
*/
def sortFile(fName: String =  verbFile, prefixes: Vector[String] = prefixList) : Unit = {
  val lines = Source.fromFile(fName).getLines.toVector
  val label = lines.head
  // pair up entries with numeric number of LS id:
  val paired = for (entry <- lines.tail.filter(_.nonEmpty)) yield {
    val cols = entry.split("#")
    // cols(1) is the Lewis-Short identifier:  strip off
    // its prefix and make it an Int for numeric sorting:
    val lexString = stripPrefix(cols(1),prefixes).replaceAll("[a-z]+$","")
    val lexNum = lexString.toInt

    (lexNum, entry)
  }
  // sort by number (part 1), produce entry only (part 2)
  val sorted = for (l <- paired.sortBy(_._1).distinct) yield {
    l._2
  }

  // rewrite file:
  new PrintWriter(fName){ write (label + "\n\n" + sorted.mkString("\n")); close;}
}

val sharedCex = Vector (
  "datasets/shared/stems-tables/adjectives/adjs.cex",
  "datasets/shared/stems-tables/adjectives/properadjs.cex",

  "datasets/shared/stems-tables/indeclinables/indecls.cex",
  "datasets/shared/stems-tables/indeclinables/numerals.cex",


  "datasets/shared/stems-tables/nouns/cognomina-ls.cex",
  "datasets/shared/stems-tables/nouns/ethnics.cex",
  "datasets/shared/stems-tables/nouns/geo-ls.cex",
  "datasets/shared/stems-tables/nouns/gods.cex",
  "datasets/shared/stems-tables/nouns/nomina-ls.cex",
  "datasets/shared/stems-tables/nouns/nouns.cex",
  "datasets/shared/stems-tables/nouns/persons.cex",
  "datasets/shared/stems-tables/nouns/hyginus.cex",

  "datasets/shared/stems-tables/verbs-compound/compverbs.cex",
  "datasets/shared/stems-tables/verbs-simplex/verbs.cex",

  "datasets/shared/irregular-stems/adverbs/advs.cex"

)

val orthoLimitedCex = Vector(
    "datasets/lat23/stems-tables/adjectives/adjs.cex",
    "datasets/lat24/stems-tables/adjectives/adjs.cex",
    "datasets/lat25/stems-tables/adjectives/adjs.cex",

    "datasets/lat23/stems-tables/indeclinables/indecls.cex",
    "datasets/lat23/stems-tables/indeclinables/numerals.cex",
    "datasets/lat24/stems-tables/indeclinables/indecls.cex",
    "datasets/lat24/stems-tables/indeclinables/numerals.cex",
    "datasets/lat25/stems-tables/indeclinables/indecls.cex",
    "datasets/lat25/stems-tables/indeclinables/numerals.cex",

    "datasets/lat23/stems-tables/nouns/nouns.cex",
    "datasets/lat23/stems-tables/nouns/nomina-ls.cex",
    "datasets/lat24/stems-tables/nouns/nouns.cex",
    "datasets/lat24/stems-tables/nouns/nomina-ls.cex",
    "datasets/lat25/stems-tables/nouns/nouns.cex",
    "datasets/lat25/stems-tables/nouns/nomina-ls.cex",

    "datasets/lat23/stems-tables/verbs-compound/compverbs.cex",
    "datasets/lat23/stems-tables/verbs-simplex/verbs.cex",

    "datasets/lat24/stems-tables/verbs-compound/compverbs.cex",
    "datasets/lat24/stems-tables/verbs-simplex/verbs.cex"  ,

    "datasets/lat25/stems-tables/verbs-compound/compverbs.cex",
    "datasets/lat25/stems-tables/verbs-simplex/verbs.cex"
)

def tidyAll : Unit = {
  for (cexFile <- sharedCex) {
    println("Sort " + cexFile + "...")
    sortFile(cexFile)
  }
  for (cexFile <- orthoLimitedCex) {
    println("Sort " + cexFile + "...")
    sortFile(cexFile)
  }

  println("\nDone tidying.")
}
println("\n\nSort a tabular file by Lewis-Short ID:\n")
println("\tsortFile([FILE], [PREFIXLIST])\n")
println("Sort predefined list of CEX files by Lewis-Short ID:\n")
println("\ttidyAll\n")
