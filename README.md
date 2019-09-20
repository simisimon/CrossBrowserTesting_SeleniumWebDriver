# CrossBrowserTesting
Repository for bachelor thesis of Sebastian Simon

Das Projekt umfasst die Integration von Testframeworks für automatisiertes Cross-Browser-Testing.
Als Testframeworks werden Selenium WebDriver und TestNG in eine Entwicklungsumgebung (Eclipse) integriert. 

Integration Selenium WebDriver
- jar-Datein und WebDriver über https://www.seleniumhq.org/download/ downloadbar
- jar-Datein müssen zum Projekt hinzugefügt werden
- Initialisierung der WebDriver im Programmcode entweder über Umgebungsvariable oder mit Pfadangabe 

Integration TestNG
- als Plugin im Eclipse Marketplace verfügbar
- muss installiert und zum Projekt hinzugefügt werden

Als erste Webanwendung wurde Mobilde.de (https://www.mobile.de/) ausgewählt, da dort verschiedene Testfälle bezüglich Anwenderfunktionen und visuellen Darstellungen abgeleitet, implementiert und überprüft werden können.
Mithilfe von Selenium und dem Page Object Pattern werden einzelne Seiten bzw. Komponenten einer Seite der Webanwendung 
in einer Klasse modelliert/implementiert. Dadurch entsteht eine Trennung zwischen WebDriver Programmcode und Testcode, die die Wartbarkeit der Tests verbessert und duplizierten Code reduziert. Durch die Integration von TestNG werden die TestNG Klasse und testng.xml erstellt. Die TestNG Klasse ist gekennzeichnet durch die @-Notationen. In der TestNG Class werdern die Testfälle implmentiert und über die XML-Datei  ausgeführt.
