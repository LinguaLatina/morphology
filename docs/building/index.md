---
layout: page
title: "Building a parser"
nav_order: 1
has_children: true
---


# Building a parser


## Prerequisites

- [prerequisites](./prerequisites/)



## Compiling a parser

This repository includes a Scala script you can use to compile morphological parsers for a specific data set, using a specific orthography.

1. From a terminal in the root directory of this repository, run `sbt console` to start an interactive Scala session
2. Load the script with `:load scripts/compile.sc` (note the leading colon!)
3. Compile a parser for the orthography of your choosing by running `compile("ORTHOGRAPHY")`.

The resulting binary parser is saved in the `parsers` directory.
