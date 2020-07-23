// Build a word list for a corpus
import edu.holycross.shot.ohco2._
import edu.holycross.shot.mid.orthography._
import edu.holycross.shot.latin._

import java.io.PrintWriter

val urls : Map[String, String] = Map(
  "hyginus" -> "https://raw.githubusercontent.com/LinguaLatina/texts/master/texts/latin23/hyginus.cex",
  "pliny" -> "https://raw.githubusercontent.com/LinguaLatina/texts/master/texts/latin24/pliny-letters.cex"
)

val orthos: Map[String, MidOrthography] = Map(
  "hyginus" -> Latin23Alphabet,
  "pliny" -> Latin24Alphabet,

)

// Create a TokenizableCorpus for pliny or hyginus
def tokenizable(corpusLabel: String) : TokenizableCorpus = {
  val url = urls(corpusLabel)
  val ortho = orthos(corpusLabel)
  val corpus = CorpusSource.fromUrl(url, cexHeader = true)
  TokenizableCorpus(corpus, ortho)
}

// Compute alphabetized list of distinct lexical tokens.
// To make it case-sensitive, include caseSensitive = true
def words(corpusLabel: String, caseSensitive: Boolean = false): Vector[String] = {
  val tcorpus = tokenizable(corpusLabel)
  caseSensitive match {
    case true => tcorpus.lexicalTokens.map(_.text.toLowerCase).distinct.sorted
    case false => tcorpus.lexicalTokens.map(_.text).distinct.sorted
  }
}



// Write alphabetized list of distinct lexical tokens to
// file name "CORPUSLABEL-words.txt".
// To make it case-sensitive, include caseSensitive = true
def writeWords(corpusLabel: String, caseSensitive: Boolean = false): Unit = {
  val wordList = words(corpusLabel, caseSensitive).mkString("\n")
  new PrintWriter(corpusLabel + "-tokens.txt"){write(wordList);close;}
}


def usage: Unit = {
  println("\n\nAvailable functions (use \"hyginus\" or \"pliny\" for \"CORPUS\"):")
  println("\n1. Create a tokenizable corpus:")
  println("\n\ttokenizable(\"CORPUS\")")

  println("\n2. Create an alphabetically sorted word list:")
  println("\n\twords(\"CORPUS\")")


  println("\n3. Write an alphabetically sorted word list to disk:")
  println("\n\twriteWords(\"CORPUS\")")
}

usage
