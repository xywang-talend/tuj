#!/usr/bin/perl

use strict;
use warnings;

use List::Util qw/shuffle/;

# force flush
$|++;

while (<STDIN>) {
    chomp;
    my @in = split /,/, $_;
    print(
        join(
            ",",
            uc $in[1],
            lc $in[0],
            $in[2] + 1
        ),
        "\n"
    );
}
