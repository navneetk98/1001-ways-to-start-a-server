package main

import (
    "fmt"
    "log"
    "net/http"
)

func defaultHandler(w http.ResponseWriter, r *http.Request) {
    if (r.URL.Path != "/" && r.URL.Path != "/home") {
        http.Error(w, "We dont serve here! Get back to your home", http.StatusNotFound)
        return
    }

    if r.Method != "GET" {
        http.Error(w, "Caught'ya!", http.StatusNotFound)
        return
    }


    fmt.Fprintf(w, "Welcome to a fake server for HacktoberFest Tshirt! :)")
}

func main() {
	
    fmt.Printf("Server starting at 8080\n")

    http.HandleFunc("/",defaultHandler)


    if err := http.ListenAndServe(":8080", nil); err != nil {
        log.Fatal(err)
    }
}