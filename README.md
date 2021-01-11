# selenium_grid

1.    Необходимо скачать selenium-server-standalone-3.141.59.jar
2.    Запускать в командной строке из папки где лежит Jar файл:
      java -jar selenium-server-standalone-3.141.59.jar -role hub
      java -jar selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register/ -port 5556 
      java -jar selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register/ -port 5555
3.    Запустить тест из класса TestRunner
