module SecretHandshake (handshake) where

codes :: [[String] -> [String]]
codes = [wink, doubleBlink, closeEyes, jump, reverse]
  where wink = (++ ["wink"])
        doubleBlink = (++ ["double blink"])
        closeEyes = (++ ["close your eyes"])
        jump = (++ ["jump"])

handshake :: Int -> [String]
handshake = foldl apply [] . zip codes . bits
  where apply lst (act, True) = act lst
        apply lst _ = lst
        bits 0 = []
        bits n = odd n : bits (n `div` 2)
