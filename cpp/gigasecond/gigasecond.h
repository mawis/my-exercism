#ifndef _GIGASECOND_H
#define _GIGASECOND_H

#include <boost/date_time/posix_time/posix_time.hpp>

using namespace boost::posix_time;

namespace gigasecond {
    ptime advance(ptime const base);
}

#endif // _GIGASECOND_H
