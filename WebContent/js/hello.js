export default function hello() {
    console.log("hello world");
}


export class TodoHistory {
    constructor(ui) {
        this.ui = ui;
        this.hashMap = new Map();
    }

    add(hashId) {
        var today = new Date()
        var todayString = today.toISOString().split('T')[0]
        console.log(todayString)
        this.hashMap.set(hashId, todayString);
    }

    isVisited(hashId) {
        var lastVisit = this.hashMap.get(hashId);
        if (lastVisit)
            return true;
        else
            return false;
    }

    load() {
        let storeString = localStorage.getItem("todo-history-" + this.ui);
        this.hashMap = new Map(JSON.parse(storeString));
    }

    save() {
        let storeString = JSON.stringify(Array.from(this.hashMap.entries()));
        localStorage.setItem("todo-history-" + this.ui, storeString);
    }
}

