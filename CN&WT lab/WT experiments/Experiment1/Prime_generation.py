<?php
$num = 2 ;
while ($num < 50 ) {
    $count=0;
    for ( $i=1;$i<=$num;$i++) {
        if (($num%$i)==0) {
            $count++;
        }
    }
    if ($count<3) {
    echo $num." , ";
    } $num=$num+1;
}

?>

Output:

2 , 3 , 5 , 7 , 11 , 13 , 17 , 19 , 23 , 29 , 31 , 37 , 41 , 43 , 47
