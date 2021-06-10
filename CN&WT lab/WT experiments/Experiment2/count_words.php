<?php

function get_num_of_words($string) { 
    $str = trim($string); 
      while (substr_count($str, "  ") > 0) { 
        $str = str_replace("  ", " ", $str); 
    } 
      return substr_count($str, " ")+1; 
} 
  
$str = "Welcome to world";  
$len = get_num_of_words($str); 
echo $len; 


Output:
3
