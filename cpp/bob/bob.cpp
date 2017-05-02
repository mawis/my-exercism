#include "bob.h"

#include <boost/algorithm/string.hpp>
#include <boost/algorithm/string/predicate.hpp>

namespace bob {
    bool isQuestion(std::string const &address) {
	return boost::algorithm::ends_with(boost::trim_right_copy(address),
					   "?");
    }

    bool isEmpty(std::string const &address) {
	return boost::trim_right_copy(address).empty();
    }

    bool isShout(std::string const &address) {
	return
	    address.find_first_of("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
	    != std::string::npos
	    && address.find_first_of("abcdefghijklmnopqrstuvwxyz")
	    == std::string::npos;
    }

    std::string hey(std::string address) {
	return isShout(address) ? "Whoa, chill out!"
	    : isQuestion(address) ? "Sure."
	    : isEmpty(address) ? "Fine. Be that way!"
	    : "Whatever.";
    }
}
