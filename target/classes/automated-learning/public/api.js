const data = {
    users: [
        {
            userId: "2a4a34e6-8b11-4929-acea-3ae73c614fb8",
            username: "demo",
            password: "password123"
        }
    ],
    contacts: [
        {
            userId: "2a4a34e6-8b11-4929-acea-3ae73c614fb8",
            contacts: 
            [
                {
                    "id": 1,
                    "first_name": "Dayna",
                    "last_name": "Allsop",
                    "email": "dallsop0@nydailynews.com",
                    "gender": "Female",
                    "phone": "325-946-7686"
                }, {
                    "id": 2,
                    "first_name": "Nesta",
                    "last_name": "Gatherer",
                    "email": "ngatherer1@dailymail.co.uk",
                    "gender": "Female",
                    "phone": "295-976-9320"
                }, {
                    "id": 3,
                    "first_name": "Ninon",
                    "last_name": "Rosbotham",
                    "email": "nrosbotham2@ask.com",
                    "gender": "Female",
                    "phone": "372-690-0560"
                }, {
                    "id": 4,
                    "first_name": "Florie",
                    "last_name": "Harper",
                    "email": "fharper3@hp.com",
                    "gender": "Female",
                    "phone": "897-576-4503"
                }, {
                    "id": 5,
                    "first_name": "Ellyn",
                    "last_name": "Lamar",
                    "email": "elamar4@earthlink.net",
                    "gender": "Female",
                    "phone": "342-161-6950"
                }, {
                    "id": 6,
                    "first_name": "Talia",
                    "last_name": "Pantin",
                    "email": "tpantin5@cbslocal.com",
                    "gender": "Female",
                    "phone": "226-851-6113"
                }, {
                    "id": 7,
                    "first_name": "Clare",
                    "last_name": "Sallier",
                    "email": "csallier6@deliciousdays.com",
                    "gender": "Male",
                    "phone": "537-595-7350"
                }, {
                    "id": 8,
                    "first_name": "Malva",
                    "last_name": "MacMarcuis",
                    "email": "mmacmarcuis7@mozilla.com",
                    "gender": "Female",
                    "phone": "407-318-1205"
                }, {
                    "id": 9,
                    "first_name": "Cherida",
                    "last_name": "Fearnyough",
                    "email": "cfearnyough8@netvibes.com",
                    "gender": "Female",
                    "phone": "733-488-4513"
                }, {
                    "id": 10,
                    "first_name": "Hamlen",
                    "last_name": "Mahood",
                    "email": "hmahood9@sciencedaily.com",
                    "gender": "Male",
                    "phone": "490-159-9317"
                }
            ]
        }
    ]
};

function setupUsers() {
    var users = window.localStorage.getItem("users");
    if(users === null)
    {
        window.localStorage.setItem("users", JSON.stringify(data.users));
    }
}

function getUser() {
    return JSON.parse(window.localStorage.getItem("users"));
}

function saveUser(user, password) {
    var users = JSON.parse(window.localStorage.getItem("users"));
    users.push({userId: guid(), username: user, password});
    window.localStorage.setItem("users", JSON.stringify(users));
    return {userId: guid(), username: user, password};
}

function getApi() {
    return data;
}

function login(username, password) {
    var result = getUser().filter(user => user.username == username && user.password == password);
    if(result.length == 0) return undefined;
    result = result[0];
    var state = buildState(result);
    window.localStorage.setItem("state", JSON.stringify(state));
    return result;
}

function buildState(user) {
    var contacts = getContacts(user.userId);
    return {
        logggedInUser: user,
        contacts
    };
}

function register(username, password) {
    var result = getUser().filter(user => user.username == username && user.password == password);
    if(result.length === 0 )
    {
        return saveUser(username, password);
    }
    return undefined;
}

function forgot(username) {
    var result = data.users.filter(user => user.username == username);
    return result.length === 0 ? undefined : result[0];
}

function getContacts(userId) {    
    var contacts = window.localStorage.getItem("contacts");
    if(contacts === null)
    {
        window.localStorage.setItem("contacts", JSON.stringify(data.contacts));
    }
    contacts = JSON.parse(window.localStorage.getItem("contacts"));
    var result = contacts.filter(c => c.userId === userId);
    return result.length === 0 ? [] : result[0];
}

function addContact(userid, contact) {
    debugger;
    var contacts = JSON.parse(window.localStorage.getItem("contacts"));
    var result = contacts.filter(c => c.userId === userid);
    if(result.length === 0 )
    {
        contact.id = 1;
        contacts.push({userId: userid, contacts: [contact]})
    }
    else
    {
        var ints = result[0].contacts.map(c => c.id);
        var maxId = Math.max(...ints);
        contact.id = ++maxId;
        result[0].contacts.push(contact);
        contacts = Object.assign(contacts, {userId: userid, contacts: result});
    }
    window.localStorage.setItem("contacts", JSON.stringify(contacts));
    var state = buildState(getState(userid).logggedInUser);
    window.localStorage.setItem("state", JSON.stringify(state));
}

function updateContact(userid, contact) {
    debugger;
    contact.id = Number.parseInt(contact.id);
    var storedContacts = JSON.parse(window.localStorage.getItem("contacts"));
    var result = storedContacts.filter(c => c.userId === userid)[0];
    result.contacts[contact.id-1] = contact;
    window.localStorage.setItem("contacts", JSON.stringify(storedContacts));
    var state = buildState(getState(userid).logggedInUser);
    window.localStorage.setItem("state", JSON.stringify(state));
}

function deleteContact(userid, id) {
    debugger;

    var storedContacts = JSON.parse(window.localStorage.getItem("contacts"));
    var result = storedContacts.filter(c => c.userId === userid)[0];
    var contact = data.contacts.find(c => c.userId == userid).contacts[id-1];

    result.contacts = result.contacts.filter(function(ele){
        return ele.id != contact.id;
    });;
    window.localStorage.setItem("contacts", JSON.stringify(storedContacts));
    var state = buildState(getState(userid).logggedInUser);
    window.localStorage.setItem("state", JSON.stringify(state));
}

function getLoggedInUserId(userId) {
    return JSON.parse(window.localStorage.getItem("state")).logggedInUser.userId;
}

function getState(userId) {
    return JSON.parse(window.localStorage.getItem("state"));
}

function getUserByLogin(userId) {
    var result = data.users.filter(user => user.username === userId);
    if(result.length == 0) return undefined;
    return result[0];
}

window.api = {
    getApi,
    login,
    register,
    forgot,
    addContact,
    getContacts,
    updateContact,
    deleteContact,
    getLoggedInUserId,
    getState,
    getUserByLogin,
    setupUsers
};

window.get = function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
};

function guid() {
    function s4() {
      return Math.floor((1 + Math.random()) * 0x10000)
        .toString(16)
        .substring(1);
    }
    return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
      s4() + '-' + s4() + s4() + s4();
}