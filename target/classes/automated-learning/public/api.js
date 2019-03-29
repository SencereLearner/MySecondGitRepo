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

function getApi() {
    return data;
}

function login(username, password) {
    var result = data.users.filter(user => user.username == username && user.password == password);
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
    var result = data.users.filter(user => user.username == username && user.password == password);
    if(result.length === 0 )
    {
        return data.users.push({username, password});
    }
    return undefined;
}

function forgot(username) {
    var result = data.users.filter(user => user.username == username);
    return result.length === 0 ? undefined : result[0];
}

function getContacts(userId) {
    var result = data.contacts.filter(c => c.userId === userId);
    return result.length === 0 ? undefined : result[0];
}

function updateContact(userid, contact) {
    contact.id = Number.parseInt(contact.id);
    data.contacts.find(c => c.userId == userid).contacts[contact.id-1] = contact;
    debugger;
    var state = buildState(getState(userid).logggedInUser);
    window.localStorage.setItem("state", JSON.stringify(state));
}

function deleteContact(userid, id) {
    var contact = data.contacts.find(c => c.userId == userid).contacts[id-1];
    data.contacts.find(c => c.userId == userid).contacts = data.contacts.find(c => c.userId == userid).contacts.filter(function(ele){
        return ele != contact;
    });
    debugger;
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
    getContacts,
    updateContact,
    deleteContact,
    getLoggedInUserId,
    getState,
    getUserByLogin
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