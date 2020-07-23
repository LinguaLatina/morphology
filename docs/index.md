---
layout: page
title: "Lingua Latina: morphological data"
---

# Lingua Latina: morphological data

The morphological data sets in this repository can be used with [tabulae](https://github.com/neelsmith/tabulae) to build corpus-specific parsers.


## How to build and use parsers

TBA

## Organization of data sets

- common to all orthographies:
    - `datasets/shared`: tables for inflectional rules and morphological stems, identified with URNs corresponding to those in [the Furman University edition of Lewis and Short's lexicon](http://folio2.furman.edu/lewis-short/index.html)
    - `datasets/shared-xls`: tables for inflectional rules and morphological stems that do not have URNs corresponding to those in [the Furman University edition of Lewis and Short's lexicon](http://folio2.furman.edu/lewis-short/index.html). (These are primarily proper nouns and adjectives.)
- orthography with 23 alphabetic characters: `datasets/lat23`
- orthography with 24 alphabetic characters: `datasets/lat24`
- orthography with 25 alphabetic characters: `datasets/lat25`
