# ICE - Projektbeskrivelse
## Hvad er det vi gerne vil bygge?
Vi vil gerne lave et *system* der kan læse CSV-filer og skrive til en *database* for en *kunde*. Det skal også kunne hente og behandle data fra databasen, og give kunden nøgletal i et dashboard.
## Til hvem?
En kunde der dagligt har brug for at få indlæst en stor CSV-fil ind i en database, samt få et overblik over dataen.
## Hvorfor?
For at udfordre os selv med et problem fra den virkelige verden.

## Funktionelle krav
Man skal kunne logge ind som bruger/kunde i systemet, uploade en CSV-fil fyldt med ordrer der efterfølgende bliver tilføjet til en database. Herefter skal kunden kunne få et overblik over nøgletal om ordrerne der er tilføjet til databasen - herunder antal salg, total indtjening, bedst sælgende produkter (inkl. total salg og indtjening), samlet antal ordrer og samlet mængde penge brugt.

Når CSV-filerne er tilføjet skal de efterfølgende gemmes lokalt, så de altid kan læses igen.

Filerne skal indlæses hurtigt og effektivt til databasen og omvendt kunne hentes igen hurtigt og effektivt. Hvis der er fejl i CSV-filerne skal der gives besked om dette, og så er det kundens opgave at rette det.

## Objektanalyse
- 
3. Domænemodel (hånd/PlantUML)

1. Klassediagram
2. Projektopsætning
3. Stub kode - klasser og tomme metoder





- I er et nyopstartet firma der specialiserer i ETL (Extract, Transform, Load) i CSV filer, samt data opbevaring.
- I har fået en ny kunde, Alibamazon, som er en online markedsplatform som er interesseret i at have jer til at håndtere deres data.
- Alibamazon's kunder har alle den samme slags konto. De køber typisk stort ind for at videresælge.
- Alibamazon understøtter indtil videre kun oprettelse af nye ordrer.

Kundens forretningsmæssige krav:
- Hver dag skal en .csv med ordrer fil loades ind på jeres database. Der kan være alt fra 0 til 3.000.000 ordrer om dagen.
- Kunden har en forventning om at der er fokus på performance. De vil gerne sikre sig at jeres produkt er skalerbare. Hvis der en dag kommer 25.000.000 ordrer ind på een dag, kan I håndtere dette?
- Kunden vil gerne kunne se nøgle tal på deres salg. De vil gerne kunne fremsøge på et produkt, og se antal salg og total indtjeninge fra salgene.
- Kunden vil gerne kunne se deres 5 bedst sælgende produkter, samt deres tilhørende totale salg og indtjening.
- Kunden vil gerne se deres bedste kunder, deres samlede antal ordrer og samlede mængde penge brugt.
- Kunden vil gerne have at de .csv filer der bliver læst ind, bliver gemt lokalt efterfølgende, så de altid kan blive læst ind igen.

Kodemæssige krav:
- Konsol applikation der køres udelukkende til at indlæse filer til Databasen. Det er dens eneste job.
- Konsol applikation der kan udstille data til Alibamazon selv. Der behøver ikke være login funktionalitet.
- Separation of Concerns - sørg for at der ikke lægges for meget ansvar i den samme metode/klasse.
- Tænk over optimering af database kaldene. Hvordan kan man gøre det hurtigere?
- Tænk over fejlhåndtering. Hvis I forventer et tal i en .csv kolonne, men der istedet står en dato eller et navn, hvad gør I så?
