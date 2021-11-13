package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/**
 *  
 */
public class Proofs {

    private TONContext context;

    public Proofs(TONContext context) {
        this.context = context;
    }

   /**
    * This function checks block proofs and compares given data with the proven.If the given data differs from the proven, the exception will be thrown.The input param is a single block's JSON object, which was queried from DApp server usingfunctions such as `net.query`, `net.query_collection` or `net.wait_for_collection`.If block's BOC is not provided in the JSON, it will be queried from DApp server(in this case it is required to provide at least `id` of block).<p>Please note, that joins (like `signatures` in `Block`) are separated entities and not supported,so function will throw an exception in a case if JSON being checked has such entities in it.<p>If `cache_in_local_storage` in config is set to `true` (default), downloaded proofs andmaster-chain BOCs are saved into the persistent local storage (e.g. file system for nativeenvironments or browser's IndexedDB for the web); otherwise all the data is cached only inmemory in current client's context and will be lost after destruction of the client.<p>**Why Proofs are needed**<p>Proofs are needed to ensure that the data downloaded from a DApp server is real blockchaindata. Checking proofs can protect from the malicious DApp server which can potentially providefake data, or also from "Man in the Middle" attacks class.<p>**What Proofs are**<p>Simply, proof is a list of signatures of validators', which have signed this particular master-block.<p>The very first validator set's public keys are included in the zero-state. Whe know a root hashof the zero-state, because it is stored in the network configuration file, it is our authorityroot. For proving zero-state it is enough to calculate and compare its root hash.<p>In each new validator cycle the validator set is changed. The new one is stored in a key-block,which is signed by the validator set, which we already trust, the next validator set will bestored to the new key-block and signed by the current validator set, and so on.<p>In order to prove any block in the master-chain we need to check, that it has been signed bya trusted validator set. So we need to check all key-blocks' proofs, started from the zero-stateand until the block, which we want to prove. But it can take a lot of time and traffic todownload and prove all key-blocks on a client. For solving this, special trusted blocks are usedin TON-SDK.<p>The trusted block is the authority root, as well, as the zero-state. Each trusted block is the`id` (e.g. `root_hash`) of the already proven key-block. There can be plenty of trustedblocks, so there can be a lot of authority roots. The hashes of trusted blocks for MainNetand DevNet are hardcoded in SDK in a separated binary file (trusted_key_blocks.bin) and canbe updated for each release.In future SDK releases, one will also be able to provide their hashes of trusted blocks forother networks, besides for MainNet and DevNet.By using trusted key-blocks, in order to prove any block, we can prove chain of key-blocks tothe closest previous trusted key-block, not only to the zero-state.<p>But shard-blocks don't have proofs on DApp server. In this case, in order to prove any shard-block data, we search for a corresponding master-block, which contains the root hash of thisshard-block, or some shard block which is linked to that block in shard-chain. After provingthis master-block, we traverse through each link and calculate and compare hashes with links,one-by-one. After that we can ensure that this shard-block has also been proven.
    *
    * @param block 
    */
    public CompletableFuture<Void> proofBlockData(Object block) {
        return context.requestJSON("proofs.proof_block_data", "{"+(block==null?"":("\"block\":"+block))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * This function requests the corresponding block, checks block proofs, ensures that given transactionexists in the proven block and compares given data with the proven.If the given data differs from the proven, the exception will be thrown.The input parameter is a single transaction's JSON object (see params description),which was queried from TONOS API using functions such as `net.query`, `net.query_collection`or `net.wait_for_collection`.<p>If transaction's BOC and/or `block_id` are not provided in the JSON, they will be queried fromTONOS API (in this case it is required to provide at least `id` of transaction).<p>Please note, that joins (like `account`, `in_message`, `out_messages`, etc. in `Transaction`entity) are separated entities and not supported, so function will throw an exception in a caseif JSON being checked has such entities in it.<p>If `cache_in_local_storage` in config is set to `true` (default), downloaded proofs andmaster-chain BOCs are saved into the persistent local storage (e.g. file system for nativeenvironments or browser's IndexedDB for the web); otherwise all the data is cached only inmemory in current client's context and will be lost after destruction of the client.<p>For more information about proofs checking, see description of `proof_block_data` function.
    *
    * @param transaction 
    */
    public CompletableFuture<Void> proofTransactionData(Object transaction) {
        return context.requestJSON("proofs.proof_transaction_data", "{"+(transaction==null?"":("\"transaction\":"+transaction))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

}
