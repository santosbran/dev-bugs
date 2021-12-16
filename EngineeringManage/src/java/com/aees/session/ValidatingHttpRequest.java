 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.


package com.aees.session;// paquete session

import javax.servlet.http.HttpServletRequest;// libreria Serializable
import javax.servlet.http.HttpServletRequestWrapper;// libreria Serializable



class ValidatingHttpRequest extends HttpServletRequestWrapper{

    public ValidatingHttpRequest(HttpServletRequest request) {
        super(request);
    }

    
    
}
