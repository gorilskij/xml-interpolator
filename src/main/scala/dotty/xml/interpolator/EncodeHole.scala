package dotty.xml.interpolator

object EncodeHole extends Function1[StringContext, String] {
  def apply(ctx: StringContext): String = {
    val parts = ctx.parts
    val sb = new StringBuilder()
    for ((part, i) <- parts.init.zipWithIndex) {
      sb.append(part)
      sb.append(Hole.encode(i))
    }
    sb.append(parts.last)
    sb.toString
  }
}