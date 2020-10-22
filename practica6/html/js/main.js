var bLogeo=document.getElementById('signin');
bLogeo.addEventListener('click',function() {
    const parametros = new URLSearchParams();
    parametros.append('Paraemail',document.getElementById('email').value);
    parametros.append('Parapassword',document.getElementById('password').value);
 /* axios.get('http://127.0.0.1:4567/hello'+ parametros)
        .then(function(response ){
            console.log(response)
            console.log(response.data)
            console.log(response.statusText)
            document.getElementById('titulo').innerHTML = response.data

        })
        .catch(function(error){
            console.log(error)
        
        })
})*/  
  axios.get('http://127.0.0.1:4567/queryparams?'+ parametros)
        .then(function(response ){
            console.log(response)
            console.log(response.data)
            console.log(response.statusText)
            document.getElementById('titulo').innerHTML = response.data

        })
        .catch(function(error){
            console.log(error)
        
        })
})         
        //Llamada POST que envia un objeto JSON
        /*axios.post('http://127.0.0.1:4567/formdata', {
        ParaEmail : document.getElementById('email').value,
        ParaPassword : document.getElementById('password').value
    })
        .then(function(response ){
            console.log(response)
            console.log(response.data)
            console.log(response.statusText)
            document.getElementById('titulo').innerHTML = response.data

        })
        .catch(function(error){
            console.log(error)
        
        })
})*/
    //Llamada POST que envia un objeto JSON
    /*axios.get('http://127.0.0.1:4567/fomrdata', parametros)
        .then(function( response ){
            console.log(response)
            console.log(response.data)
            console.log(response.statusText)
            document.getElementById('titulo').innerHTML = response.data

        })
        .catch(function(error){
            console.log(error)
        
        })
})*/
