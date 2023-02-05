import { Injectable } from '@angular/core';
import * as CryptoJS from 'crypto-js';

@Injectable({
  providedIn: 'root'
})
export class Crypto {

  secretKey = "bank&&chn";
  constructor() { }

  encrypt(value : string) : string{
    var cryp = CryptoJS.AES.encrypt(value, this.secretKey.trim()).toString();
    return cryp.replace(/\+/g,'p1L2u3S').replace(/\//g,'s1L2a3S4h').replace(/=/g,'e1Q2u3A4l');;
  }

  decrypt(textToDecrypt : string){
    textToDecrypt = textToDecrypt.replace(/p1L2u3S/g, '+' ).replace(/s1L2a3S4h/g, '/').replace(/e1Q2u3A4l/g, '=');
    return CryptoJS.AES.decrypt(textToDecrypt, this.secretKey.trim()).toString(CryptoJS.enc.Utf8);
  }
}