# ComposeCryptoCurrency
 This application shows a list of cryptocurrencies with basic information (description, founder and tags). That application is developed using Jetpack Compose, MVVM and Clean Architecture.

## Add packages
- Common
- Presentation
- Domain
- Data
- DI (Dependent injection)

### Common
- Add Constants
- Add sealed class Resource with Success, Error and Loading

### Presentation
- add packages (coin_list & coin_detail)
- add packages components

### Domain
- add package model
- add package repository
- add package use_case
- in package use_case add get_coins & get_coint

### Data
- add package remote
- add package repository
- add package dto

## Api used
- [coinpaprica](https://coinpaprika.com/es/)