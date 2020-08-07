var ping;
var webSocket;
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
        webSocket = new WebSocket($('#target').val());
        webSocket.onopen = function (evt) {
            writeStatus("CONNECTED");
            let ping = setInterval(function () {
                if (webSocket != "undefined") {
                    webSocket.send("ping")
                }
            }, 10000);
        };

        webSocket.onclose = function (evt) {
            writeStatus("DISCONNECTED")
        };

        webSocket.onmessage = function (evt) {
            if (evt.data === "ping") {
                writePing(evt.data);
            } else {
                writeMessage('ECHO:' + evt.data);
            }
        };

        webSocket.onerror = function (evt) {
            onerror(writeStatus('ERROR:' + evt.data));
        };
    });

    $('#disconnect').click(function () {
        if (typeof webSocket != 'undefined') {
            webSocket.close();
            webSocket = undefined;
        } else {
            alert("Not connected.");
        }
    });

    $('#send').click(function () {
        if(typeof webSocket != 'undefined') {
            webSocket.send($('#message').val());
        } else {
            alert("Not connected.")
        }
    });
});