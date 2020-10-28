package com.radiance.tonclient;

/**
 *  
 */
public class CryptoConfig {

    private Number mnemonicDictionary;
    /**
     * 
     */
    public Number getMnemonicDictionary() {
        return mnemonicDictionary;
    }
    /**
     * 
     */
    public void setMnemonicDictionary(Number value) {
        mnemonicDictionary = value;
    }

    private Number mnemonicWordCount;
    /**
     * 
     */
    public Number getMnemonicWordCount() {
        return mnemonicWordCount;
    }
    /**
     * 
     */
    public void setMnemonicWordCount(Number value) {
        mnemonicWordCount = value;
    }

    private String hdkeyDerivationPath;
    /**
     * 
     */
    public String getHdkeyDerivationPath() {
        return hdkeyDerivationPath;
    }
    /**
     * 
     */
    public void setHdkeyDerivationPath(String value) {
        hdkeyDerivationPath = value;
    }

    private Boolean hdkeyCompliant;
    /**
     * 
     */
    public Boolean getHdkeyCompliant() {
        return hdkeyCompliant;
    }
    /**
     * 
     */
    public void setHdkeyCompliant(Boolean value) {
        hdkeyCompliant = value;
    }


    @Override
    public String toString() {
        return "{\"mnemonic_dictionary\":"+mnemonicDictionary+",\"mnemonic_word_count\":"+mnemonicWordCount+",\"hdkey_derivation_path\":\""+hdkeyDerivationPath+"\",\"hdkey_compliant\":"+hdkeyCompliant+"}";
    }
}