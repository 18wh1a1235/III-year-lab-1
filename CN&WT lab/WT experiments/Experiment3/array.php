<?php
    $a1=array(1,3,15,7,5);
    $a2=array(4,3,20,1,11);
    $mer = array_merge($a1,$a2);
   rsort($mer);
    print_r($mer);
?>

*Output:

Array
(
    [0] => 20
    [1] => 15
    [2] => 11
    [3] => 7
    [4] => 5
    [5] => 4
    [6] => 3
    [7] => 3
    [8] => 1
    [9] => 1
)*/
