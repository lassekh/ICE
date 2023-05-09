# ICE - Projektbeskrivelse
1. Hvad er det vi gerne vil bygge?
2. Til hvem?
3. Hvorfor?

1. Funktionelle krav
2. Objektanalyse
3. Domænemodel (hånd/PlantUML)

1. Klassediagram
2. Projektopsætning
3. Stub kode - klasser og tomme metoder

Vi vil gerne lave et system der kan læse CSV-filer og skrive til en database.

Man skal kunne logge ind som bruger i systemet, uploade en fil og vælge om dataen skal indlæses i en ny database tabel el. tilføjes til en eksisterende database tabel.

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
