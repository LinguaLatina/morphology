---
layout: page
title: "Lingua Latina Legenda: morphological data"
nav_order: 0
---

# *Lingua Latina Legenda*: morphological data

The morphological data sets in this repository can be used with [tabulae](https://github.com/neelsmith/tabulae) to build corpus-specific parsers.


## How to build and use parsers

- [building a parser](./building/)
- parsing data

## Organization of data sets

The `datasets` directory is organized to facilitate building parallel parsers supporting three different orthographies of Latin, one using 23 alphabetic characters (no consonanatal `v` or `j`), one using 24 alphabetic characters (consonantal `v` but not `j`) and one using 25 alphabetic characters (both consonantal `v` and `j`).  The five subdirectories contain tabular data files organized according to the requirements of the [`tabulae`  system](https://github.com/neelsmith/tabulae).


- common to all orthographies:
    - `datasets/shared`: tables for inflectional rules and morphological stems, identified with URNs corresponding to those in [the Furman University edition of Lewis and Short's lexicon](http://folio2.furman.edu/lewis-short/index.html)
    - `datasets/shared-xls`: tables for inflectional rules and morphological stems that do not have URNs corresponding to those in [the Furman University edition of Lewis and Short's lexicon](http://folio2.furman.edu/lewis-short/index.html). (These are primarily proper nouns and adjectives.)
- orthography with 23 alphabetic characters: `datasets/lat23`
- orthography with 24 alphabetic characters: `datasets/lat24`
- orthography with 25 alphabetic characters: `datasets/lat25`
