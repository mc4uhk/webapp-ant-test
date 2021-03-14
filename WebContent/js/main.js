import hello, { TodoHistory } from './hello.js'

hello();

var todoHistory = new TodoHistory('87722');


var hashId = 'dajd74ds3241289asdsdasdd';

todoHistory.load()

console.log(todoHistory.ui);
console.log(todoHistory.add(hashId));
console.log(todoHistory.isVisited(hashId));
console.log(todoHistory.isVisited(hashId + 'dkjsajdl'));

todoHistory.save()