---
layout: page
title: "Building a parser"
nav_order: 1
has_children: true
---


# Building a parser


## Prerequisites

- [prerequisites](./prerequisites/)

## Data sets

The `datasets` directory is organized to facilitate building parallel parsers supporting three different orthographies of Latin, one using 23 alphabetic characters (no consonanatal `v` or `j`), one using 24 alphabetic characters (consonantal `v` but not `j`) and one using 25 alphabetic characters (both consonantal `v` and `j`).  The five subdirectories contain tabular data files organized according to the requirements of the [`tabulae`  system](https://github.com/neelsmith/tabulae).

- `shared` and `shared_xls` include data common to all of the orthographies
- `lat23`, `lat24` and `lat25` include data specific to one orthography




## Compiling a parser

This repository includes a Scala script you can use to compile morphological parsers for a specific data set, using a specific orthography.

1. From a terminal in the root directory of this repository, run `sbt console` to start an interactive Scala session
2. Load the script with `:load scripts/compile.sc` (note the leading colon!)
3. Compile a parser for the orthography of your choosing by running `compile("ORTHOGRAPHY")`.

The resulting binary parser is saved in the `parsers` directory.
