# FX Calculator

A console-based currency converter application.

## Requirements

The application allows a user to convert an amount in a specific currency to the equivalent amount in another currency.

This application allows a user to enter an amount in any of the known currencies, and provide the equivalent amount in another currency.

This application parses console input like "<ccy1> <amount1> in <ccy2>", and provides a suitable response.

Example:

```
AUD 100.00 in USD
AUD 100.00 = USD 83.71

AUD 100.00 in AUD
AUD 100.00 = AUD 100.00

AUD 100.00 in DKK
AUD 100.00 = DKK 505.76

JPY 100 in USD
JPY 100 = USD 0.83
```
If the rate cannot be calculated, the program will alert the user as follows:

```
KRW 1000.00 in FJD
Unable to find rate for KRW/FJD
```

## Getting Started

### Prerequisites

Java 8
Maven 3.5.3


### Setup

#### Through Command Line

Run the following maven commands from the root source directory to get started

To download and install all dependencies:

```
mvn clean install -DskipTests
```

Run the tests:

```
mvn clean test
```

Run the application (main method):

```
mvn exec:java
```

#### Through Eclipse

* Open eclipse.
* Click File > Import.
* Type Maven in the search box under Select an import source:
* Select Existing Maven Projects.
* Click Next.
* Click Browse and select the folder that is the root of the Maven project (probably contains the pom.xml file)
* Click Next.
* Click Finish.