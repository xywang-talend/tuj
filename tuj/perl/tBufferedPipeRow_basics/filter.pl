#!/usr/bin/perl

use strict;
use warnings;

# force flush
$|++;

while (<STDIN>) {
    chomp;
    my @fields = split /,/, $_;

    if ($fields[0] + $fields[1] > 10) {
        print join(',', @fields), "\n";
    }
}
