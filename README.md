# Test 3-5
Third test version 5 from subject PB162 on [FI MUNI](https://www.fi.muni.cz/)

## Description (Czech language only)
Rozhraní ani předdefinované třídy neměňte, pokud to přímo nevyžaduje zadání. Metody NEMUSÍTE dokumentovat pomocí JavaDoc komentářů. Používejte zásadně privátní atributy.
Úloha simuluje orientovaný graf.


**Zadání:**

-   Vytvořte třídu DirectedGraph implementující rozhraní IDirectedGraph. Tj. pro každý uzel grafu je třeba si pamatovat sousední uzly, do kterých vede (orientovaná) hrana.

**Poznámky a rady:**
- Pokud se rozhodnete uzavírat vstup/výstup, tak myslete na to, že k uzavření by mělo dojít za všech okolností, tedy i pokud dojde k chybě.
 - Je třeba programovat defenzivně, tj. např. správně ošetřit případný chybný formát dat načítaných ze vstupního proudu.



Třída Demo by při správném řešení měla vypsat:


        Reading graph from graph.txt...OK
        Number of edges (expected 4): 4
        Adding new edge
        Number of edges (expected 5): 5
        Adding duplicate edge
        Number of edges (expected 5): 5
        Removing existing edge
        Number of edges (expected 4): 4
        Removing non-existing edge
        Number of edges (expected 4): 4
        Test of existing paths: OK
        Test of non-existing paths: OK

        save -- line order doesn't matter:
        A:E
        A:B
        B:C
        C:D


## License
MIT