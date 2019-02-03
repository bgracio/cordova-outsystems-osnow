var exec = require('cordova/exec');

module.exports = {
  loadUrl: function(hostname, appName) {
    exec(null, null, "OSNow", 'loadUrl', [hostname, appName]);
  }
};
