# MyTicketApi

## Présentation
ce mini-projet est un résumé simplifié du code de notre API<br/>
Il permet de récupérer les tickets avec toutes leurs propriétés.<br/>
Ces propriétés proviennent de deux sources différentes.

## Les sources (repository)
Ce sont des API dans la réalite.<br/>
Ici, elles sont remplacées par des classes de tests avec des instances de ticket écrites en dure dans le code.

### les métadatas
interface du repo : MetadataTicketRepository <br/>
Il s'agit de récupérer certaines données des tickets : label, conditions, description

### le ticketing
interface du repo : TicketingTicketRepository <br/>
Cela concerne le prix du ticket, le fait qu'il soit daté ou non et sa validité

## Les classes tickets

### le ticket de la métadata
classe : TicketFromMetadata <br/>
peut être récupéré selon son id.<br/>
contient les propriétés suivantes : 
- label
- conditions
- description

### le ticket de la billetterie
classe : TicketFromTicketing <br/>
peut être récupéré selon son id.<br/>
contient les propriétés suivantes : 
- prix
- isDated
- validityStartDate
- validityEndDate

### le ticket qu'on veut récupérer
classe : Ticket <br/>
doit contenir les propriété suivantes : 
- id 
- label
- conditions
- description
- prix
- isDated
- validityStartDate
- validityEndDate

## L'aggregator
classe : TicketAggregator <br/>
Il appelle les interface de repository.<br/>
Il contient plusieurs fonctions non implémentées.<br/>
L'objectif est de les implémenter pour récupérer un ticket selon son id, la liste des tickets, la liste des tickets sous conditions.

## Le test de l'aggregator
classe : TicketAggregatorTest <br/>
permet de testes les fonctions de l'aggregator.<br/>
Un premier test est implémenté : listTickets, il faut le passer en vert.<br/>
Il faudra ensuite écrire les tests suivants avec d'écrire les fonctions de l'aggregator
