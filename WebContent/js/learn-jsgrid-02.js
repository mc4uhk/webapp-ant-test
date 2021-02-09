//update field if click on Not the cell
$(function () {
    $("#jsGrid").on("click", (args) => {
        console.log(args.target);
        if (!$(args.target).is("td") && !$(args.target).is("input")) {
            $("#jsGrid").jsGrid("updateItem");
        }
    });

    $("#sortable").sortable({
        deactivate: function (event, ui) {
            saveOrder();
        },
    });
    $("#sortable").disableSelection();
    restoreOrder();
    loadRemovedIds();
    loadOrientation();
    activateSwapPanel();
});

function goSave() { }
function goTest() {
    console.log("Test");
    console.log(JSON.stringify(clients));
}

var isEditing = false;
var clients = [
    {
        Name: "Otto Clay",
        Age: 25,
        Country: 1,
        Address: "Ap #897-1459 Quam Avenue",
        Married: false,
        courses: [{ name: "Chinese" }, { name: "English" }, { name: "Math" }],
    },
    {
        Name: "Connor Johnston",
        Age: 45,
        Country: 2,
        Address: "Ap #370-4647 Dis Av.",
        Married: true,
    },
    {
        Name: "Lacey Hess",
        Age: 29,
        Country: 3,
        Address: "Ap #365-8835 Integer St.",
        Married: false,
    },
    {
        Name: "Timothy Henson",
        Age: 56,
        Country: 1,
        Address: "911-5143 Luctus Ave",
        Married: true,
    },
    {
        Name: "Ramona Benton",
        Age: 32,
        Country: 3,
        Address: "Ap #614-689 Vehicula Street",
        Married: false,
    },
];

var countries = [
    { Name: "", Id: 0 },
    { Name: "United States", Id: 1 },
    { Name: "Canada", Id: 2 },
    { Name: "United Kingdom", Id: 3 },
];

$("#jsGrid").jsGrid({
    width: "100%",

    editing: true,
    sorting: true,
    paging: true,

    data: clients,

    rowClick: function (args) {
        if (this._editingRow) this.updateItem();

        console.log(this._editingRow);
        console.log(args);
        console.log(args.item.Married);

        if (this.editing) {
            this.editItem($(args.event.target).closest("tr"));
        }
    },

    fields: [
        {
            name: "Name",
            type: "text",
            width: 150,
            validate: "required",
            editing: false,
        },
        { name: "Age", type: "number", width: 50, editing: true },
        { name: "Address", type: "text", width: 200, editing: true },
        {
            name: "Country",
            type: "select",
            items: countries,
            valueField: "Id",
            textField: "Name",
        },
        {
            name: "Married",
            type: "checkbox",
            title: "Is Married",
            sorting: false,
        },
    ],
});

function showSelected() {
    // clients.forEach((client, i) => console.log(client.Married ? i : ""));
    console.log(clients.filter((client) => client.Married));
}

var tooltipTriggerList = [].slice.call(
    document.querySelectorAll('[data-bs-toggle="tooltip"]')
);
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl);
});

$(document).resize($("#pageWidth").html($(document).width()));

function saveOrder() {
    var itemList = $("#sortable");
    var order = itemList.sortable("toArray").toString();
    console.log(order);
    localStorage.setItem("listOrder", order);
}

function restoreOrder() {
    var itemList = $("#sortable");
    var order = localStorage.getItem("listOrder");
    if (order) {
        $.each(order.split(","), function (i, id) {
            //appending the element with the ID given id should move each element to the end of the
            // list one after another, and at the end, the order should be restored.
            $("#" + id).appendTo(itemList);
        });
    }
}

var orientation01;
function loadOrientation() {
    orientation01 = localStorage.getItem("orientation");
    if (orientation01 == null)
        orientation01 = 'vert';
    setView(orientation01);
}

function saveOrientation() {
    localStorage.setItem("orientation", orientation01);
}

function insertCard(id) {
    const multiple = Math.floor(Math.random() * 5) + 1;

    let content = `Some quick example text to build on the card title and make up the
    bulk of the card's content. `

    content = content.repeat(multiple)

    let newCard = `<div id="${id}" class="card01 align-self-start card-size">
        <div class="card01-body p-1">
          <div data-todo-group="${id}" style="display: flex; ">
          <h5 class="card-title p-1" data-todo-id="${id}" style="flex-grow:1">${id}</h5>
          <span class="card-control" style="padding-right:10px;" onclick="remove('${id}')">X</span>
          </div>
          <h6 class="card01-subtitle mb-2 text-muted p-1">Card subtitle</h6>
          <p class="card01-text p-1">
            ${content}
          </p>
          <div class="card01-row">
            <div style="width: 60%; background-color: pink;">Hi There!</div>
            <div class="card01-row" style="flex-warp: nowarp; flex-grow: 1;" >
              <div style="flex-grow: 1; background-color: green">-1</div>
              <div style="flex-grow: 1; background-color: yellow">-1</div>
              <div style="flex-grow: 1; background-color: red">-1</div>
            </div>
          </div>
        </div>
      </div>`;

    var itemList = $("#sortable");
    itemList.append(newCard);
}

function remove(id) {
    console.log(id);
    $("#" + id).fadeOut(1500, () => {
        $("#" + id).addClass('hidden')
        saveRemovedIds();
    });
    SwapItems = { first: '', second: '' };
}

function saveRemovedIds() {
    let ids = [];
    $(".hidden").each(function () { ids.push(this.id); });
    console.log(ids);
    localStorage.setItem("removed-ids", ids);
}

function loadRemovedIds() {
    var removedIds = localStorage.getItem("removed-ids");
    if (removedIds) {
        $.each(removedIds.split(","), function (i, id) {
            $("#" + id).addClass("hidden");
        });
    }

}

insertCard("panel01");
insertCard("panel02");
insertCard("panel03");
insertCard("panel04");
insertCard("panel05");
insertCard("panel06");
insertCard("panel07");
insertCard("panel08");
insertCard("panel09");

function reset() {
    localStorage.clear();
    location.reload();
}

function swapView() {
    orientation01 = orientation01 == 'vert' ? 'hori' : 'vert';
    saveOrientation();

    $('.main-content').toggleClass("vert");
    $('.main-content').toggleClass("hori");
    $('.top-left-panel').toggleClass("vert");
    $('.top-left-panel').toggleClass("hori");
    $('.bottom-right-panel').toggleClass("vert");
    $('.bottom-right-panel').toggleClass("hori");
    $('.card-size').toggleClass("vert");
    $('.card-size').toggleClass("hori");
}

function setView(ori) {
    $('.main-content').addClass(ori);
    $('.top-left-panel').addClass(ori);
    $('.bottom-right-panel').addClass(ori);
    $('.card-size').addClass(ori);
}

function swap(swapItems) {
    node1 = $('#' + swapItems.first).get(0)
    node2 = $('#' + swapItems.second).get(0)
    const afterNode2 = node2.nextElementSibling;
    const parent = node2.parentNode;
    node1.replaceWith(node2);
    parent.insertBefore(node1, afterNode2);
}

function swapElement(swapItems) {
    a = $('#' + swapItems.first)
    b = $('#' + swapItems.second)
    // create a temporary marker div
    var aNext = $('<div>').insertAfter(a);
    a.insertAfter(b);
    b.insertBefore(aNext);
    // remove marker div
    aNext.remove();
}

var SwapItems = { first: '', second: '' }
function activateSwapPanel() {
    $("[id^=panel]").click(function (e) {
        if (SwapItems.first != '' && SwapItems.second != '')
            SwapItems = { first: '', second: '' };

        const currId = e.currentTarget.id;
        console.log(currId);
        $('#' + currId).effect("highlight", 1000);
        if (SwapItems.first == '')
            SwapItems.first = currId;
        else {
            SwapItems.second = currId;
            swapElement(SwapItems);
            saveOrder();
            SwapItems = { first: '', second: '' };
        }

        console.log(SwapItems);
    });
}