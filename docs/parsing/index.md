---
layout: page
title: "Parsing a word list"
nav_order: 2
has_children: true
---



# Parsing a word list

## Build a word list

You can use the `wordList.sc` script in the scripts folder.  From a terminal in the repository's root directory:

1. `sbt console`
2. `:load scripts/wordList.sc`
3. `writeWords("CORPUS")` ("CORPUS" = "hyginus" or "pliny")

This creates a file named "CORPUS-tokens.txt".

## Analyzing a word list

The basic form of the command to parse a word list is

`sfst PARSER WORDLIST`

Your parser will be named `latin.a` in a subdirectory of the `parsers` directory.  If you used the script as described above to create your wordlist, it will be named `CORPUS-tokens.txt`.

This command will write the results to standard output (i.e, to your terminal screen).  To save the results to a file at the same time you're watching the results scroll by, use `tee`:

`sfst PARSER WORDLIST | tee OUTPUT.fst`

### Example

You're parsing a word list you made for Hyginus with the 23-alphabetic character parser, and want to save the results to a file.  You could do this:


`sfst parsers/shared-shared-xls-lat23/latin.a hyginus-tokens.txt
 | tee hyginus-parsed.fst`
