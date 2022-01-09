# KARBO TIPUN BOT

Welcome to [Karbo](https://karbo.org/) tip bot. You can tell me to tip users with KRB previously deposited with me.

First you need to deposit some KRB to the address I’ll give you in a transaction **with your personal Payment ID** assigned to you. **Make sure you send KRB with this Payment ID** otherwise they won’t be credited

Here’s the list of available commands:

```
/address - show deposit address and your personal Payment ID.
/balance - show your balance.
/info - show the information about the bot and commands
/tip - (or tipkrb for not karbo chats) send a tip to user, e.g. /tip <amount> @username as well as reply to users’ message with /tip  <amount>
/rain - (or rainrkb for not karbo chats) make a rain to most active users in the chat, e.g. /rain <amount> <number of users> <last hours> or without hours (24h by default) /rain <amount> <number of users>
/withdraw  - cash out your KRB. The total commission is 0.11 KRB
```

# How to run

## Start simplewallet

1. Download the latest version for your platform:
```shell
https://github.com/seredat/karbowanec/releases/latest
```
2. Extract files:
```shell
tar -xzf Karbo-cli-*
```
3. Run simplewallet to generate a new wallet
```shell
simplewallet --generate-new-wallet test --pass=P@ssw0rd --daemon-address=krb.rublin.org
```
4. Run the wallet with rpc support
```shell
simplewallet --wallet-file=test --pass=P@ssw0rd --rpc-bind-port=8888 --rpc-bind-ip=0.0.0.0 --daemon-address=krb.rublin.org
```
5. Call get_address method to verify if everything works fine:
```shell
curl -X POST --location "http://localhost:8888/json_rpc" \
    -H "Content-Type: application/json" \
    -d "{
          \"jsonrpc\" : \"2.0\",
          \"id\" : \"test\",
          \"method\" :\"get_address\",
          \"params\" : {}
        }"
```