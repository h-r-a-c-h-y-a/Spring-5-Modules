var ping;
var sockjs;
jQuery(function($){
    function writePing(message) {
        $('#pingOutPut').append(message +'\n');
    }

    function writeStatus(message) {
        $('#statusOutPut')
            .val($('#statusOutPut').val() + message + '\n');
    }

    function writeMessage(message) {
        $('#messageOutPut').append(message + '\n');
    }

    $('#connect').click(function doConnect() {
        sockjs = new SockJS($('#target').val());
        sockjs.onopen = function (evt) {
            writeStatus("CONNECTED");
            let ping = setInterval(function () {
                if (sockjs != "undefined") {
                    sockjs.send("ping")
                }
            }, 10000);
        };

        sockjs.onclose = function (evt) {
            writeStatus("DISCONNECTED")
        };

        sockjs.onmessage = function (evt) {
            if (evt.data === "ping") {
                writePing(evt.data);
            } else {
                writeMessage('ECHO:' + evt.data);
            }
        };

        sockjs.onerror = function (evt) {
            onerror(writeStatus('ERROR:' + evt.data));
        };
    });

    $('#disconnect').click(function () {
        if (typeof sockjs != 'undefined') {
            sockjs.close();
            sockjs = undefined;
        } else {
            alert("Not connected.");
        }
    });

    $('#send').click(function () {
        if(typeof sockjs != 'undefined') {
            sockjs.send($('#message').val());
        } else {
            alert("Not connected.")
        }
    });
});