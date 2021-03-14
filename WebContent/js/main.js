import hello, { TodoHistory } from './hello.js'
import { v4 as uuidv4 } from 'uuid';

hello();

var todoHistory = new TodoHistory('87722');


var hashId = 'dajd74ds3241289asdsdasdd';

hashId = uuidv4()
console.log(hashId);

todoHistory.load()

console.log(todoHistory.ui);
console.log(todoHistory.add(hashId));
console.log(todoHistory.isVisited(hashId));
console.log(todoHistory.isVisited(uuidv4()));

//todoHistory.reset();

todoHistory.save()

console.log("hi yoo");



