document.addEventListener("DOMContentLoaded", function(event) {

  // Build a system
  const ui = SwaggerUIBundle({
    url: "/services/swagger.json",
    dom_id: '#swagger-ui',
    presets: [
      SwaggerUIBundle.presets.apis,
      SwaggerUIStandalonePreset
    ],
    plugins: [
      SwaggerUIBundle.plugins.DownloadUrl
    ],
    layout: "StandaloneLayout"
  })

  window.ui = ui
  //run the code here
});