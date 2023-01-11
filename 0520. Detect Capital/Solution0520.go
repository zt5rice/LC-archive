package main

import (
	"fmt"
	"strings"
)

func main() {
	word := "USA"
	res := detectCapitalUse(word)
	fmt.Println(word + ":" + fmt.Sprintf("%t", res))

	word2 := "FlaG"
	res2 := detectCapitalUse(word2)
	fmt.Println(word2 + ":" + fmt.Sprintf("%t", res2))
}

func detectCapitalUse(word string) bool {
	cap := 0
	first := false
	// str := []rune(word)
	for i := 0; i < len(word); i++ {
		if i == 0 && isUpper(word[i]) {
			first = true
		}
		if isUpper(word[i]) {
			cap++
		}
	}
	return (cap == 0 || cap == len(word) || (cap == 1 && first))
}

func isUpper(c byte) bool {
	if c >= 'A' && c <= 'Z' {
		return true
	}
	return false
}

func detectCapitalUse2(word string) bool {
	allCap := strings.ToUpper(word)
	remainingPart := strings.ToLower(word)[1:]

	return word == allCap || word[1:] == remainingPart
}
