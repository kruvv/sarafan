#SARAFAN

Требуется установленный yarn или mpm

1. Инициализируем yarn в терминале командой yarn init 
на все вопросы жмем Enter
2. Добавляем yarn add vue vue-resource
3. Добавляем девелоперский зависимости 
yarn add -D webpack webpack-cli webpack-dev-server babel-loader @babel/core @babel/preset-env vue-loader vue-template-compiler
4. Добавить в package-json скрипт запускающий сервер "scripts": {"start": "webpack-dev-server"}
5. Добавить webpack.config.js
7. В конфигуриции добавить в Environment variables: spring.profiles.active=dev
6. Добавить yarn add -D vuex vuetify css-loader @stomp/stompjs @babel/polyfill

